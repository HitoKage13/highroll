import React, { useState, useCallback } from 'react';
import "../styles/main.css";
import { Stack, InputGroup, Input, InputLeftAddon } from "@chakra-ui/react"

export default function Search(props) {
    function handleChange(event) {
        const { onChange } = props;
        onChange(event.target.value);
        event.preventDefault();
    }
    
    return(
        <Stack spacing={4}>
            <InputGroup>
            <InputLeftAddon
            pointerEvents="none"
            backgroundColor="white"
                    children={<img src="./assets/icons/Misc_StandardBook.png" width="30" color="gray.300" />}
            />
            <Input type="" color="black" placeholder="Search a card..." onChange={handleChange} />
        </InputGroup>
        </Stack>
    )
}