import React, { useState } from 'react';
import './App.css';

function App() {
  const [isLoggedIn, setIsLoggedIn] = useState(false);
  const [username, setUsername] = useState('');


  const flights = [
    { id: 1, airline: 'Air India', departure: '09:00 AM', arrival: '12:00 PM', price: 7500 },
    { id: 2, airline: 'IndiGo', departure: '11:30 AM', arrival: '02:30 PM', price: 6500 },
    { id: 3, airline: 'SpiceJet', departure: '03:15 PM', arrival: '06:15 PM', price: 5500 },
  ];


  const handleLogin = (e) => {
    e.preventDefault();
    setIsLoggedIn(true);
    setUsername('DemoUser');
  };


  const handleLogout = () => {
    setIsLoggedIn(false);
    setUsername('');
  };

  return (
    <div className="app">
      <header>
        <h1>Flight Ticket Booking</h1>
        {isLoggedIn ? (
          <div className="user-controls">
            <span>Welcome, {username}</span>
            <button onClick={handleLogout}>Logout</button>
          </div>
        ) : (
          <form onSubmit={handleLogin} className="login-form">
            <button type="submit">Login</button>
          </form>
        )}
      </header>

      <main>
        <h2>Available Flights</h2>
        <div className="flight-list">
          {flights.map(flight => (
            <div key={flight.id} className="flight-card">
              <h3>{flight.airline}</h3>
              <p>Departure: {flight.departure}</p>
              <p>Arrival: {flight.arrival}</p>
              <p>Price: ₹{flight.price}</p>
              {isLoggedIn && (
                <button className="book-btn">Book Now</button>
              )}
            </div>
          ))}
        </div>
      </main>

      {!isLoggedIn && (
        <div className="guest-message">
          <p>Please login to book tickets</p>
        </div>
      )}
    </div>
  );
}

export default App;