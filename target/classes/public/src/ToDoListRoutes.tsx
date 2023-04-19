import './ToDoListRoutes.css';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import { createTheme, ThemeProvider } from '@mui/material/styles';

import Login from './components/login/Login';
import ToDoListMainPage from './components/ToDoListMainPage';
import rtlPlugin from 'stylis-plugin-rtl';
import { prefixer } from 'stylis';

import { CacheProvider } from '@emotion/react';
import createCache from '@emotion/cache';

const theme = createTheme({
  direction: 'rtl',
});
const cacheRtl = createCache({
  key: 'muirtl',
  stylisPlugins: [prefixer, rtlPlugin],
});


const App = () => {
  return (
      <CacheProvider value={ cacheRtl }>
        <ThemeProvider theme={ theme }>
          <BrowserRouter>
            <Routes>
              <Route path="/">
                <Route index element={ <Login/> }/>
                <Route path="/ToDoList" element={ <ToDoListMainPage/> }/>
              </Route>
            </Routes>
          </BrowserRouter>
        </ThemeProvider>
      </CacheProvider>);
};

export default App;
