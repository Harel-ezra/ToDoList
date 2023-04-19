import React, { useState } from "react";
import TextField from '@mui/material/TextField';
// @ts-ignore
import loginCss from './Login.module.css';
import DialogTitle from '@mui/material/DialogTitle';
import Button from '@mui/material/Button';
import Box from '@mui/material/Box';
import { Link } from "react-router-dom";
import { LogInButton } from "../button/LogInButton";
import { useDispatch } from "react-redux";
import { setData } from "./../../redux";
import { useNavigate } from 'react-router-dom';


const Login = () => {
  const dispatch = useDispatch();
  const [loginName, setLoginName] = useState('');
  const handleInputName = (event: React.ChangeEvent<HTMLInputElement>) => {
    setLoginName(event.target.value);
  }
  const navigate = useNavigate();

  const loginRoute = () => {
    if (loginName == '') {
      alert("הכנס את השם שלך");
    } else {
      dispatch(setData(loginName));
      navigate("/ToDoList");
    }
  }
  return (
      <Box className={ loginCss.loginBox }>
        <DialogTitle id={ loginCss.header }>המשימות שלי</DialogTitle>
        <TextField

            id="nameLogin"
            label="השם שלך"
            variant="outlined"
            onChange={ handleInputName }
            onKeyDown={ (key) => {
              if (key.key == "Enter") {
                loginRoute();
              }
            } }
        />
        <Button size='large' variant="contained" onClick={ loginRoute }>התחבר</Button>
      </Box>
  )
}


export default Login;