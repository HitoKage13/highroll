import logo from './logo.svg';
import { React, useState } from 'react';
import { Home } from './components';
import './App.css';

function App() {
    return (
        <div className="App">
            <header className="App-header">
                <Home></Home>
            </header>
        </div>
    );
}

export default App;
