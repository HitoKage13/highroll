import React, { useState, useEffect } from 'react';
import "../styles/main.css";
import "../styles/CardDisplay.css";
import Search from './Search';
// import images from '../data/testimages.js';
import { Button, Container } from "@chakra-ui/react"

export default function CardDisplay(props) {
    // search cards
    const [cardList, setCards] = useState([]);
    const [selectedCard, setSelected] = useState(null);
    
    // query
    const [query, setQuery] = useState([]);

    // update useEffects
    const [updateCardList, setUpdateCards] = useState(false);
    const [updateQuery, setUpdateQuery] = useState(false);

    // search bar
    const [value, setValue] = useState(null);

    async function handleChange(searchTerm) {
        setValue(searchTerm);
        setTimeout(function () {
            setUpdateCards(!updateCardList);
        }, 300);
    };

    // updates on search
    useEffect(() => {
        const res = fetch('http://localhost:8080/cards/search/' + value,
            {
                crossDomain: true,
                method: 'GET',
                headers: {
                    'Content-Type': 'application/json',
                }
            }
        ).then(response => {
            if (response.status === 200) {
                if (value !== null) {
                    response.json().then(data => {
                        setCards(data);
                        console.log(data);
                    });
                }
            } else {
                console.log("Fail");
            }
        })
        .catch(function (error) {
            console.log('Looks like there was a problem: ', error);
        });
    }, [updateCardList]);

    // updates for queries
    useEffect(() => {
        const res = fetch('http://localhost:8080/cards/data/' + selectedCard,
            {
                crossDomain: true,
                method: 'GET',
                headers: {
                    'Content-Type': 'application/json',
                }
            }
        ).then(response => {
            if (response.status === 200) {
                if (value !== null) {
                    response.json().then(data => {
                        setQuery(data);
                        console.log(data);
                    });
                }
            } else if (response.status === 500) {
                setQuery([]);
                console.log("Fail");
            }
        })
            .catch(function (error) {
                console.log('Looks like there was a problem: ', error);
            });
    }, [updateQuery]);

    // updates the searched cards
    function update() {
        setUpdateCards(true);
    }

    // triggers the query search
    function triggerQuery(card) {
        setCards([card]);
        setValue('');
        setSelected(card.name);
        setUpdateQuery(!updateQuery);
        // e.preventDefault();
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
            <p>Target: {selectedCard}</p>
            <Container class="container flex flex-wrap justify-center">
                {cardList.map((card, key) => {
                    return(
                        <img class="selectedCard" onClick={() => triggerQuery(card)} value={card.name} src={card.image}/>
                    );
                })}
            </Container>
            {query.length > 0 && <img class="divider" src="./assets/hs-divider.png" />}
            <Container class="container flex flex-wrap">
                {query.map((card, key) => {
                    return (
                        <img class="selectedCard" src={card.image} />
                    );
                })}
            </Container>
        </Container>
    )
}