import React, { useState } from 'react';

function CurrencyConverter() {
    const [rupees, setRupees] = useState('');
    const [euros, setEuros] = useState('');
    const [conversionRate] = useState(0.011);

    const handleSubmit = (e) => {
        e.preventDefault();
        if (rupees) {
            const convertedValue = parseFloat(rupees) * conversionRate;
            setEuros(convertedValue.toFixed(2));
        }
    };

    return (
        <form onSubmit={handleSubmit}>
            <div>
                <label>
                    Indian Rupees:
                    <input
                        type="number"
                        value={rupees}
                        onChange={(e) => setRupees(e.target.value)}
                    />
                </label>
            </div>
            <button type="submit">Convert to Euros</button>
            {euros && (
                <div>
                    <p>Converted Amount: {euros} Euros</p>
                </div>
            )}
        </form>
    );
}

export default CurrencyConverter;