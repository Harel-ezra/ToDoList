// @ts-ignore
import MyMissionStyle from "../ToDoList.module.css";
import React, { useState } from 'react';
import DeleteIcon from '@mui/icons-material/Delete';
import EditIcon from '@mui/icons-material/Edit';
import CheckIcon from '@mui/icons-material/Check';
import { Box, Checkbox, IconButton, Input, Typography } from '@mui/material';

interface MissionList {
  mission: string
  removeToDo: (mission: string) => void;
}

export const Mission = ({ mission, removeToDo }: MissionList) => {
  const [isDone, setIsDone] = useState(false);
  const [editing, setEditing] = useState(false);
  const [text, setText] = useState(mission);
  const checkboxClicked = () => {
    setIsDone(!isDone);
  }
  const handleEditing = () => {
    setEditing(!editing)
  }
  const editToDo = () => {
    setEditing(!editing)
  }
  const deleteToDo = () => {
    console.log(mission);
    removeToDo(text);
  }
  const handleInputBlur = () => {
    setEditing(false);
  };

  const handleInputChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    setText(event.target.value);
  };
  return (
      <Box className={ MyMissionStyle.missionData }>
        <Checkbox checked={ isDone } onClick={ checkboxClicked }/>
          { editing ?
              (<>
                  <Input value={ text }
                         onChange={ handleInputChange }
                         onKeyDown={ (key) => {
                           if (key.key == "Enter") {
                             setEditing(false);
                           }
                         }
                         } onBlur={ handleInputBlur }/>
              <DoneEdit func={ handleInputBlur }/>
              </>)
              :
              (<>
                <Typography>
                  { text }
                </Typography>
                <Box sx={ { display: 'flex', flexDirection: 'row', alignItems: 'center' }}>
                  <EditToDoButton func={ editToDo }/>
                  <DeleteToDoButton func={ deleteToDo }/>
                </Box>

              </>) }

      </Box>)
}


interface ButtonFunction {
  func: () => void
}

const DeleteToDoButton = ({ func }: ButtonFunction) => {
  return (<Box sx={ { display: 'flex', flexDirection: 'column' } }>
    <IconButton onClick={ () => func() }>
      <DeleteIcon/>
    </IconButton>
    <Typography>מחק
    </Typography>
  </Box>);

}
const EditToDoButton = ({ func }: ButtonFunction) => {
  return (<Box sx={ { display: 'flex', flexDirection: 'column' } }>
    <IconButton onClick={ func }>
      <EditIcon/>
    </IconButton>
    <Typography>ערוך
    </Typography>
  </Box>);
}

const DoneEdit=({ func }: ButtonFunction)=>
{
  return( <Box>
        <IconButton onClick={func}>
          <CheckIcon></CheckIcon>
        </IconButton>
    <Typography>בוצע</Typography>
  </Box>

  )
}
