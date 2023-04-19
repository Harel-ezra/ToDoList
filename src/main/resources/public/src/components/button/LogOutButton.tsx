// @ts-ignore
import MyMissionStyle from "../ToDoList.module.css";
import { Link } from "react-router-dom";
import Button from '@mui/material/Button';
import Box from '@mui/material/Box';
import { setData, getData, DataStore } from "./../../redux";
import { useDispatch, useSelector } from "react-redux";
// @ts-ignore
import buttonStyle from './button.module.css'

export const LogOutButton = () => {
  const loginName = useSelector((state: DataStore) => state.logInName);
  return (
      <Box className={ MyMissionStyle.LogOut }>
        <div className={ MyMissionStyle.padding2 }> שלום, { loginName }</div>
        <Link to="/">
          <Button id={buttonStyle.logOutButton} variant="contained">התנתק</Button>
        </Link>
      </Box>
  )
}
