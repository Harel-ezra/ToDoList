import { IconButton, InputAdornment, List } from "@mui/material";
import SearchIcon from "@mui/icons-material/Search";
import React, { useState } from "react";
// @ts-ignore
import MyMissionStyle from './../ToDoList.module.css';
import { TextField, ListItem, ListItemText } from '@mui/material';

interface MissionList {
  toDoList: string[];
  searchFilterList: (mission: string) => void;
}

export const SearchToDo = ({ toDoList,searchFilterList }: MissionList) => {
  const handleInputSearch = (event: React.ChangeEvent<HTMLInputElement>) => {
    searchFilterList(event.target.value);
  }
  return (
    <TextField label="חפש משימה"
               InputProps={ {
                 endAdornment: (
                     <InputAdornment position="start">
                       <IconButton>
                         <SearchIcon/>
                       </IconButton>
                     </InputAdornment>
                 ),
               } }
               onChange={ handleInputSearch }
    />)
}