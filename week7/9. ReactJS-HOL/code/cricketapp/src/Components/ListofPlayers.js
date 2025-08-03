import React from 'react';

const ListofPlayers = () => {
    const players = [
        { name: 'Virat Kohli', score: 95 },
        { name: 'Rohit Sharma', score: 88 },
        { name: 'Shikhar Dhawan', score: 67 },
        { name: 'KL Rahul', score: 45 },
        { name: 'Rishabh Pant', score: 82 },
        { name: 'Hardik Pandya', score: 36 },
        { name: 'Jadeja', score: 74 },
        { name: 'Ashwin', score: 91 },
        { name: 'Bumrah', score: 53 },
        { name: 'Shami', score: 42 },
        { name: 'Kuldeep', score: 79 },
    ];

    const topScorers = players.filter(player => player.score >= 70);

    return (
        <div>
            <h2>All Players</h2>
            <ul>
                {players.map((player, index) => (
                    <li key={index}>
                        {player.name} — {player.score}
                    </li>
                ))}
            </ul>

            <h2>Top Scorers (70+)</h2>
            <ul>
                {topScorers.map((player, index) => (
                    <li key={index}>
                        {player.name} — {player.score}
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default ListofPlayers;
