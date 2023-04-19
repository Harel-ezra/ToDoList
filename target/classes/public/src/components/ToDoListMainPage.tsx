import Box from '@mui/material/Box';
// @ts-ignore
import MyMissionStyle from './ToDoList.module.css';
import { MissionList } from './mission/MissonList';
import { AddToDo } from './mission/AddMission'
import { SearchToDo } from "./mission/SearchToDo";
import { Header } from './header/header'
import { useState } from "react";

let missionDB = ["לסיים תחפיפה", "להשתחרר", "לעשות לעשות", "אההה", "לאכול", "שוקולד בשקם"];
const ToDoListMainPage = () => {
  const [toDoesList, setToDoList] = useState(missionDB);
  const listBackup=[missionDB];
  const addMissionToList = (mission: string) => {
    missionDB=[...toDoesList, mission];
    setToDoList(missionDB)
  }
  const removeMissionFromList = (mission: string) => {
    missionDB=toDoesList.filter((missionString: string) => missionString != mission);
    setToDoList(missionDB);
  }
  const searchToDoList=(searchKey:string)=>
  {
    const missionFilter = searchKey != '' ? missionDB.filter((mission) => {
      return mission.toLowerCase().startsWith(searchKey.toLowerCase());
    }) : missionDB;
    console.log(missionFilter);
    setToDoList(missionFilter);
  }
  return (
      <Box className={ MyMissionStyle.mainPageContainer }>
        <Header/>
        <Box className={ MyMissionStyle.taskContainer }>
          <SearchToDo toDoList={toDoesList} searchFilterList={searchToDoList}/>
          <AddToDo setToDoList={ addMissionToList } />
        </Box>
        <MissionList toDoesList={ toDoesList } removeToDo={ removeMissionFromList }/>
      </Box>
  )
}

export default ToDoListMainPage;





