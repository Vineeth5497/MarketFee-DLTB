(function checkAuth() {
    if (!sessionStorage.getItem('employeeId')) {
        window.location.href = 'index.html';
    }
})();

function logout() {
    sessionStorage.removeItem('employeeId');
    window.location.href = 'index.html';
}
