import React, { useState, useEffect } from 'react';
import "../styles/main.css";
import "../styles/CardDisplay.css";
import Search from './Search';
import images from '../data/testimages.js';
import { Button, Container } from "@chakra-ui/react"

export default function CardDisplay(props) {
    const [selectedCard, setSelectedCard] = useState(null);
    const [updateSelCard, setUpdateCard] = useState(false);
    const [cardList, setCards] = useState(images);
    const [value, setValue] = useState(null);
    async function handleChange(searchTerm) {
        setValue(searchTerm);
    };

    useEffect(() => {
        // const proxy = "https://cors-anywhere.herokuapp.com/";
        const res = fetch('http://localhost:8080/cards/search/' + value,
            {
                crossDomain: true,
                method: 'GET',
                headers: {
                    'Content-Type': 'application/json',
                    /* "Access-Control-Allow-Origin": "*",
                    "Access-Control-Expose-Headers": "Content-Length, X-JSON",
                    "Access-Control-Allow-Methods": "GET, POST, PATCH, PUT, DELETE, OPTIONS",
                    "Access-Control-Allow-Headers": "*", */
                }
            }
        ).then(response => {
            if (response.status === 200) {
                if (value !== null) {
                    response.json().then(data => {
                        setSelectedCard(data.image);
                        setUpdateCard(!updateSelCard);
                    });
                }
            } else {
                console.log("Fail");
            }
        })
        .catch(function (error) {
            console.log('Looks like there was a problem: ', error);
        });
    }, [updateSelCard]);

    function update() {
        setUpdateCard(!updateSelCard);
    }

    return(
        <Container class="container p-1 m-1">
            <Container class="container flex justify-center">
                <Search onChange={handleChange}></Search>
            </Container>
            <Button backgroundColor="red" onClick={update}>
                Select
            </Button>
            <p>Card: {value}</p>
            <Container class="container bg-red-400 flex justify-center">
                <img class="selectedCard" src={selectedCard}></img>
            </Container>
            <Container class="container flex flex-wrap card-bg">
                {cardList.map((img, key) => {
                    return(
                        <img class="cardImg" src={img}></img>
                    )
                })}
            </Container>
        </Container>
    )
}