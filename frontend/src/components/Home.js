import React, { useState, useCallback } from 'react';
import "../styles/main.css";
import "../styles/CardDisplay.css";
import { CardDisplay, ClassSelect, Search } from '../components';
import images from '../data/testimages.js';
import { Container, Box, Input } from "@chakra-ui/react"

export default function Home(props) {
    const [view, setView] = useState('class');
    const [classes, setClass] = useState(null);
    const [value, setValue] = useState('');
    async function handleChange(searchTerm) {
        setValue(searchTerm);
    };

    function changeView() {

    }

    return(
        <Container class="container mx-w-full">
            <Container class="bg-yellow-400 flex justify-center p-2 m-2">
                <Search onChange={handleChange}></Search>
            </Container>
            <p>Current Class: {classes}</p>
            {view === 'class' && <ClassSelect setClass={setClass} setView={setView}></ClassSelect>}
            {view === 'cards' && <CardDisplay></CardDisplay>}
        </Container>
    )
}