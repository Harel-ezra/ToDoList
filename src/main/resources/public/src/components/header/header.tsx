// @ts-ignore
import MyMissionStyle from "../ToDoList.module.css";
import Box from '@mui/material/Box';
import { Typography } from '@mui/material';
import { LogOutButton } from '../button/LogOutButton'

export const Header = () => {
  return (
      <Box className={ MyMissionStyle.header }>
        <Typography id={ MyMissionStyle.titleHeader }>המשימות שלי</Typography>
        <LogOutButton/>
      </Box>
  )
}