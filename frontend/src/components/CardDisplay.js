import React, { useState, useCallback } from 'react';
import "../styles/main.css";
import "../styles/CardDisplay.css";
import images from '../data/testimages.js';
import { Container, Grid, Input} from "@chakra-ui/react"

export default function CardDisplay(props) {
    const [cardList, setCards] = useState(images);
    return(
        <Container class="container p-5 m-5">
            <Container class="bg-pink-400 sm:bg-green-400 flex flex-wrap">
                {cardList.map((img, key) => {
                    return(
                        <img className="cardImg" src={img}></img>
                    )
                })}
            </Container>
        </Container>
    )
}