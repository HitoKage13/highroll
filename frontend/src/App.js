import logo from './logo.svg';
import { React, useState } from 'react';
import { CardDisplay, Search } from './components';
import './App.css';

function App() {
    const [value, setValue] = useState('');
    async function handleChange(searchTerm) {
        setValue(searchTerm);
    };

    return (
        <div className="App">
            <header className="App-header">
                <Search onChange={handleChange}></Search>
                <p>Card: {value}</p>
                <CardDisplay></CardDisplay>
            </header>
        </div>
    );
}

export default App;
