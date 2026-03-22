function toggleForms(e) {
    if(e) e.preventDefault();
    const loginForm = document.getElementById('loginForm');
    const signupForm = document.getElementById('signupForm');
    
    if (loginForm.classList.contains('active-form')) {
        loginForm.classList.remove('active-form');
        signupForm.classList.add('active-form');
    } else {
        signupForm.classList.remove('active-form');
        loginForm.classList.add('active-form');
    }
}

function submitLoginForm(e) {
    e.preventDefault();
    const form = document.getElementById('loginForm');
    if (!form.checkValidity()) {
        form.reportValidity();
        return;
    }
    
    const employeeId = document.getElementById('loginEmployeeId').value;
    const password = document.getElementById('loginPassword').value;
    const msgDiv = document.getElementById('loginMessage');
    const btn = document.getElementById('loginBtn');
    
    msgDiv.className = 'message';
    msgDiv.textContent = 'Authenticating...';
    btn.disabled = true;

    fetch('/api/auth/login', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ employeeId, password })
    })
    .then(res => res.json())
    .then(data => {
        if (data.success) {
            msgDiv.className = 'message success';
            msgDiv.textContent = 'Login successful! Redirecting...';
            sessionStorage.setItem('employeeId', employeeId);
            setTimeout(() => { window.location.href = 'home.html'; }, 800);
        } else {
            msgDiv.className = 'message error';
            msgDiv.textContent = data.message || 'Login failed';
            btn.disabled = false;
        }
    })
    .catch(err => {
        msgDiv.className = 'message error';
        msgDiv.textContent = 'Network error occurred.';
        btn.disabled = false;
        console.error(err);
    });
}

function submitSignupForm(e) {
    e.preventDefault();
    const form = document.getElementById('signupForm');
    if (!form.checkValidity()) {
        form.reportValidity();
        return;
    }

    const employeeCodeInput = document.getElementById('signupEmployeeCode').value.trim().toUpperCase();
    if (employeeCodeInput !== 'DLTB-A' && employeeCodeInput !== 'DLTB-B') {
        const msgDiv = document.getElementById('signupMessage');
        msgDiv.className = 'message error';
        msgDiv.textContent = 'Invalid Employee Code. Please enter a valid code (DLTB-A or DLTB-B).';
        return;
    }

    const data = {
        employeeId: document.getElementById('signupEmployeeId').value,
        employeeCode: document.getElementById('signupEmployeeCode').value,
        emailId: document.getElementById('signupEmail').value,
        dateOfBirth: document.getElementById('signupDob').value,
        password: document.getElementById('signupPassword').value
    };
    const msgDiv = document.getElementById('signupMessage');
    const btn = document.getElementById('signupBtn');
    
    msgDiv.className = 'message';
    msgDiv.textContent = 'Creating account...';
    btn.disabled = true;

    fetch('/api/auth/signup', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(data)
    })
    .then(res => res.json())
    .then(data => {
        if (data.success) {
            msgDiv.className = 'message success';
            msgDiv.textContent = 'Account created successfully! Please Sign In.';
            setTimeout(() => { 
                form.reset();
                toggleForms(); 
                btn.disabled = false; 
                msgDiv.textContent = '';
            }, 2000);
        } else {
            msgDiv.className = 'message error';
            msgDiv.textContent = data.message || 'Signup failed';
            btn.disabled = false;
        }
    })
    .catch(err => {
        msgDiv.className = 'message error';
        msgDiv.textContent = 'Network error occurred.';
        btn.disabled = false;
        console.error(err);
    });
}
