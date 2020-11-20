import React, { useState } from 'react';
import "../styles/main.css";
import "../styles/CardDisplay.css";
import { Container } from "@chakra-ui/react"

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
        <Container class="container p-2 m-2">
            <p>Class: {numba} </p>
            <Container class="flex flex-wrap p-2 m-2 card-bg">
                <img className="classImg" src="./assets/portraits/demon-hunter-illidan.png" alt="dh" onClick={() => chooseClass(0)}></img>
                <img className="classImg" src="./assets/portraits/druid-malfurion.png" alt="druid" onClick={() => chooseClass(1)}></img>
                <img className="classImg" src="./assets/portraits/hunter-rexxar.png" alt="hunter" onClick={() => chooseClass(2)}></img>
                <img className="classImg" src="./assets/portraits/mage-jaina.png" alt="mage" onClick={() => chooseClass(3)}></img>
                <img className="classImg" src="./assets/portraits/paladin-uther.png" alt="paladin" onClick={() => chooseClass(4)}></img>
                <img className="classImg" src="./assets/portraits/priest-anduin.png" alt="priest" onClick={() => chooseClass(5)}></img>
                <img className="classImg" src="./assets/portraits/rogue-valeera.png" alt="rogue" onClick={() => chooseClass(6)}></img>
                <img className="classImg" src="./assets/portraits/shaman-thrall.png" alt="shaman" onClick={() => chooseClass(7)}></img>
                <img className="classImg" src="./assets/portraits/warlock-guldan.png" alt="warlock" onClick={() => chooseClass(8)}></img>
                <img className="classImg" src="./assets/portraits/warrior-garrosh.png" alt="warrior" onClick={() => chooseClass(9)}></img>

            </Container>
        </Container>
    )
}