import React from 'react'
import ReactDOM from 'react-dom/client'
import App from '../../ToDoListRoutes'
import './HomePage.css'
import { Provider } from "react-redux";
import store from "../../redux";

ReactDOM.createRoot(document.getElementById('root') as HTMLElement).render(
    <React.StrictMode>
      <Provider store={ store }>
        <App/>
      </Provider>
    </React.StrictMode>,
)