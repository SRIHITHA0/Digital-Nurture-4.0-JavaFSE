// src/components/LoginControl.js
import React, { useState } from 'react';
import GuestPage from './GuestPage';
import UserPage from './UserPage';

function LoginControl() {
    const [isLoggedIn, setIsLoggedIn] = useState(false);

    const handleLogin = () => setIsLoggedIn(true);
    const handleLogout = () => setIsLoggedIn(false);

    return (
        <div>
            {isLoggedIn ? <UserPage /> : <GuestPage />}
            <button onClick={isLoggedIn ? handleLogout : handleLogin}>
                {isLoggedIn ? 'Logout' : 'Login'}
            </button>
        </div>
    );
}

export default LoginControl;
