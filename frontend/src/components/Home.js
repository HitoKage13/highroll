import React, { useState, useCallback } from 'react';
import "../styles/main.css";
import "../styles/CardDisplay.css";
import { CardDisplay, ClassSelect, Search } from '../components';
import images from '../data/testimages.js';
import { Container, Box, Input } from "@chakra-ui/react"

export default function Home(props) {
    const [view, setView] = useState('class');
    const [value, setValue] = useState('');
    const [classes, setClass] = useState(null);
    async function handleChange(searchTerm) {
        setValue(searchTerm);
    };

    function changeView() {

    }

    return(
        <Container class="container mx-w-full">
            <Search onChange={handleChange}></Search>
            <p>Current Class: {classes}</p>
            <p>Card: {value}</p>
            {view === 'class' && <ClassSelect setClass={setClass} setView={setView}></ClassSelect>}
            {view === 'cards' && <CardDisplay></CardDisplay>}
        </Container>
    )
}