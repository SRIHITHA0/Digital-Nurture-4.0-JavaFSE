import React from 'react';

const OfficeList = () => {
    const officeData = [
        {
            name: 'WorkNest',
            rent: 62000,
            address: 'Gachibowli, Hyderabad',
            image: 'https://dwarakagroup.com/wp-content/uploads/2023/05/sdfasdf.png'
        },
    ];

    return (
        <div>
            { }
            <h1 style={{ textAlign: 'center' }}>Office Space Rental App</h1>

            { }
            <div style={{ display: 'flex', gap: '20px', justifyContent: 'center' }}>
                {officeData.map((office, index) => {
                    const rentColor = {
                        color: office.rent < 60000 ? 'red' : 'green',
                        fontWeight: 'bold'
                    };

                    return (
                        <div key={index} style={{ border: '1px solid #ccc', padding: '15px', borderRadius: '10px' }}>
                            <img src={office.image} alt={office.name} style={{ width: '100%', borderRadius: '8px' }} />
                            <h2>{office.name}</h2>
                            <p><strong>Address:</strong> {office.address}</p>
                            <p><strong>Rent:</strong> <span style={rentColor}>₹{office.rent}</span></p>
                        </div>
                    );
                })}
            </div>
        </div>
    );
};

export default OfficeList;
