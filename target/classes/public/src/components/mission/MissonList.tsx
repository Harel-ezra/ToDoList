// @ts-ignore
import MyMissionStyle from '../ToDoList.module.css';
import { Mission } from './Mission';
import Box from "@mui/material/Box";
import { List, ListItem, ListItemText, Divider } from '@mui/material';
import React, { useState } from 'react';

interface MissionList
{
  toDoesList:string[];
  removeToDo:(mission:string)=>void;
}

export const MissionList = ({toDoesList,removeToDo}:MissionList) => {
  return (
      <Box className={MyMissionStyle.missionListBox}>
        <List className={ MyMissionStyle.missionList }>
          { toDoesList.map((toDo,index) => (
              <ListItem className="missionBox">
                <Mission key={toDo} mission={ toDo } removeToDo={removeToDo} />
              </ListItem>
          )) }
        </List>
      </Box>
  )
}