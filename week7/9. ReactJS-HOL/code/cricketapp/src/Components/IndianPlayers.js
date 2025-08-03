import React from 'react';

const IndianPlayers = () => {
    const T20players = ['Virat', 'Rohit', 'Surya', 'Rishabh'];
    const RanjiTrophyPlayers = ['Pujara', 'Iyer', 'Jadeja', 'Ishant'];

    const allPlayers = [...T20players, ...RanjiTrophyPlayers];

    const evenTeam = [];
    const oddTeam = [];

    allPlayers.forEach((player, index) => {
        if (index % 2 === 0) {
            evenTeam.push(player);
        } else {
            oddTeam.push(player);
        }
    });

    return (
        <div>
            <h2>All Indian Players</h2>
            <p><strong>All:</strong> {allPlayers.join(', ')}</p>

            <h3>Even Team</h3>
            <ul>
                {evenTeam.map((player, i) => (
                    <li key={i}>{player}</li>
                ))}
            </ul>

            <h3>Odd Team</h3>
            <ul>
                {oddTeam.map((player, i) => (
                    <li key={i}>{player}</li>
                ))}
            </ul>
        </div>
    );
};

export default IndianPlayers;
