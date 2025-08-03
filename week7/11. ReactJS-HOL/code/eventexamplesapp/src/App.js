import React, { useState } from 'react';
import './App.css';
import CurrencyConverter from './CurrencyConverter';

function App() {
  const [count, setCount] = useState(0);
  const [message, setMessage] = useState('');

  const incrementCount = () => {
    setCount(prevCount => prevCount + 1);
  };

  const sayHello = () => {
    setMessage('Hello! This is a static message.');
  };

  const handleIncrement = (e) => {
    incrementCount();
    sayHello();
  };

  const decrementCount = () => {
    setCount(prevCount => prevCount - 1);
  };

  const greetUser = (greeting) => {
    setMessage(`${greeting} to our event examples app!`);
  };

  const handleClick = (e) => {
    setMessage('I was clicked');
    console.log('Synthetic event:', e);
    console.log('Native event:', e.nativeEvent);
  };

  return (
    <div className="app">
      <h1>React Event Examples</h1>

      <div className="section">
        <h2>Counter Example</h2>
        <p>Count: {count}</p>
        <button onClick={handleIncrement}>Increment</button>
        <button onClick={decrementCount}>Decrement</button>
      </div>

      <div className="section">
        <h2>Welcome Message</h2>
        <button onClick={() => greetUser('Welcome')}>Say Welcome</button>
      </div>

      <div className="section">
        <h2>Synthetic Event</h2>
        <button onClick={handleClick}>Click Me</button>
      </div>

      <div className="section">
        <h2>Currency Converter</h2>
        <CurrencyConverter />
      </div>

      {message && <div className="message">{message}</div>}
    </div>
  );
}

export default App;