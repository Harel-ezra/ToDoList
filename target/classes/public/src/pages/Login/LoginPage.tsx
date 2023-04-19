import React from 'react'
import ReactDOM from 'react-dom/client'
import ToDoList from '../../ToDoListRoutes'
import './LoginPage.css'
import { Provider } from "react-redux";
import store from "../../redux";

ReactDOM.createRoot(document.getElementById('root') as HTMLElement).render(
    <React.StrictMode>
      <Provider store={ store }>
        <ToDoList/>
      </Provider>
    </React.StrictMode>,
)


