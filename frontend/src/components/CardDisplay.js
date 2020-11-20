import React, { useState, useCallback } from 'react';
import "../styles/main.css";
import "../styles/CardDisplay.css";
import Search from './Search';
import images from '../data/testimages.js';
import { Container, Grid, Input} from "@chakra-ui/react"

export default function CardDisplay(props) {
    const [selectedCard, setSelectedCard] = useState("https://d15f34w2p8l1cc.cloudfront.net/hearthstone/e14df9d01b2410548835ba1e2eb8d8592c230f581be911f89db0c492d2ced252.png")
    const [cardList, setCards] = useState(images);
    const [value, setValue] = useState('');
    async function handleChange(searchTerm) {
        setValue(searchTerm);
    };

    return(
        <Container class="container p-1 m-1">
            <Container class="container flex justify-center">
                <Search onChange={handleChange}></Search>
            </Container>
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