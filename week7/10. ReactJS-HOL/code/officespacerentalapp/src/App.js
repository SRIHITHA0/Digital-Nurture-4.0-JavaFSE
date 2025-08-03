import React from 'react';
import './App.css';

// Office data array
const officeSpaces = [
  {
    id: 2,
    name: "DBS",
    rent: 50000,
    address: "Chennai",
    image: "https://images.unsplash.com/photo-1524758631624-e2822e304c36?ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60"
  },
];

function App() {
  return (
    <div className="app">
      <h1 className="header">Office Space, at Affordable Range</h1>

      <div className="office-list">
        {officeSpaces.map(office => (
          <div key={office.id} className="office-card">
            <h2>{office.name}</h2>
            <img src={office.image} alt={office.name} className="office-image" />
            <p><strong>Address:</strong> {office.address}</p>
            <p>
              <strong>Rent:</strong>
              <span style={{ color: office.rent < 60000 ? 'red' : 'green' }}>
                ₹{office.rent.toLocaleString()}
              </span>
            </p>
          </div>
        ))}
      </div>
    </div>
  );
}

export default App;