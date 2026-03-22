/**
 * Immediately-Invoked Function Expression (IIFE) that runs on script load.
 * Checks if the user is authenticated by looking for 'employeeId' in sessionStorage.
 * If not authenticated, forcefully redirects the user to the login page.
 */
(function checkAuth() {
    if (!sessionStorage.getItem('employeeId')) {
        window.location.replace('index.html');
    }
})();

/**
 * Event listener for 'pageshow' to handle Back/Forward cache (bfcache) navigation.
 * If the user clicks the browser's Back button after logging out, this ensures
 * they cannot view cached protected pages and are redirected to the login page.
 */
window.addEventListener('pageshow', function (event) {
    if (event.persisted || (window.performance && window.performance.navigation.type === 2)) {
        if (!sessionStorage.getItem('employeeId')) {
            window.location.replace('index.html');
        }
    }
});

/**
 * Clears the user's session data and redirects them to the login page.
 */
function logout() {
    sessionStorage.removeItem('employeeId');
    window.location.replace('index.html');
}
