import React, { useState, useCallback } from 'react';
import "../styles/main.css";
import "../styles/CardDisplay.css";
import images from '../data/testimages.js';
import { Container, Box, Input } from "@chakra-ui/react"

export default function ClassSelect(props) {
    const [numba, setNum] = useState(10);

    function chooseClass(e) {
        setNum(e);
        props.setView('cards');
        switch (e) {
            case 0:
                props.setClass('demon-hunter');
                return;
            case 1:
                props.setClass('druid');
                return;
            case 2:
                props.setClass('hunter');
                return;
            case 3:
                props.setClass('mage');
                return;
            case 4:
                props.setClass('paladin');
                return;
            case 5:
                props.setClass('priest');
                return;
            case 6:
                props.setClass('rogue');
                return;
            case 7:
                props.setClass('shaman');
                return;
            case 8:
                props.setClass('warlock');
                return;
            case 9:
                props.setClass('warrior');
                return;
            default:
                props.setClass(null);
                return;
        }
    }

    return(
        <Container class="container p-5 m-5">
            <p>Class: {numba} </p>
            <Container class="flex flex-wrap p-3 m-3">
                <img className="cardImg" src="./assets/portraits/demon-hunter-illidan.png" onClick={() => chooseClass(0)}></img>
                <img className="cardImg" src="./assets/portraits/druid-malfurion.png" onClick={() => chooseClass(1)}></img>
                <img className="cardImg" src="./assets/portraits/hunter-rexxar.png" onClick={() => chooseClass(2)}></img>
                <img className="cardImg" src="./assets/portraits/mage-jaina.png" onClick={() => chooseClass(3)}></img>
                <img className="cardImg" src="./assets/portraits/paladin-uther.png" onClick={() => chooseClass(4)}></img>
                <img className="cardImg" src="./assets/portraits/priest-anduin.png" onClick={() => chooseClass(5)}></img>
                <img className="cardImg" src="./assets/portraits/rogue-valeera.png" onClick={() => chooseClass(6)}></img>
                <img className="cardImg" src="./assets/portraits/shaman-thrall.png" onClick={() => chooseClass(7)}></img>
                <img className="cardImg" src="./assets/portraits/warlock-guldan.png" onClick={() => chooseClass(8)}></img>
                <img className="cardImg" src="./assets/portraits/warrior-garrosh.png" onClick={() => chooseClass(9)}></img>

            </Container>
        </Container>
    )
}