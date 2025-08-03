import React, { Component } from 'react';

class EventExamples extends Component {
    constructor(props) {
        super(props);
        this.state = {
            count: 1,
        };

        this.increment = this.increment.bind(this);
        this.decrement = this.decrement.bind(this);
        this.sayWelcome = this.sayWelcome.bind(this);
        this.handleClick = this.handleClick.bind(this);
    }

    increment() {
        this.setState({ count: this.state.count + 1 });
    }

    decrement() {
        this.setState({ count: this.state.count - 1 });
    }

    sayWelcome() {
        alert("welcome");
    }

    handleClick() {
        alert("I was clicked");
    }

    render() {
        return (
            <div style={{ padding: '10px' }}>
                <div>{this.state.count}</div>
                <button onClick={this.increment}>Increment</button><br /><br />
                <button onClick={this.decrement}>Decrement</button><br /><br />
                <button onClick={this.sayWelcome}>Say welcome</button><br /><br />
                <button onClick={this.handleClick}>Click on me</button>
            </div>
        );
    }
}

export default EventExamples;
