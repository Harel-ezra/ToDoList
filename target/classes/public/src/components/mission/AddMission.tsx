import AddIcon from '@mui/icons-material/Add';
import { IconButton, InputAdornment, TextField } from "@mui/material";
import React, { ChangeEvent, useState } from "react";

type setCallBackFunction = (mission: string) => void;

interface MissionListProps {
  setToDoList: (mission: string) => void;
}

export const AddToDo = (props: MissionListProps) => {

  const [toDoInput, setToDoInput] = useState<string>('')

  const addingToDo = () => {
    if (toDoInput == '') {
      alert("לא אפשרי להוסיף משימה ריקה");
    } else {
      props.setToDoList(toDoInput);
      setToDoInput('');
    }
  }
  const updateToDoInput = (event: ChangeEvent<HTMLInputElement>) => {
    setToDoInput(event.target.value);
  }

  return (
      <TextField value={ toDoInput }
                 label="הוסף משימה"
                 onChange={ updateToDoInput }
                 onKeyDown={ (key) => {
                   if (key.key == "Enter") {
                     addingToDo();
                   }
                 }
                 }
                 InputProps={ {
                   endAdornment: (
                       <InputAdornment position="start">
                         <IconButton>
                           <AddIcon onClick={ addingToDo }/>
                         </IconButton>
                       </InputAdornment>
                   ),
                 } }/>
  );
}