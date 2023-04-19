import { Link } from "react-router-dom";
import Button from '@mui/material/Button';

export const LogInButton=()=>
{
  return(<Link to="ToDoList">
        <Button variant="contained" onClick={ loginRoute }>התחבר</Button>
      </Link>

  )
}
const loginRoute = () => {
}
