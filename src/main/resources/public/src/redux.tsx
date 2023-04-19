import { createStore } from 'redux'

export interface DataStore {
  logInName: string;
}

const dataStore: DataStore = {
  logInName: ""
};

interface SetData {
  type: "SET_DATA";
  payload: string;
}

interface GetData {
  type: "GET_DATA";
}

type pagesFunction = SetData | GetData;

export const setData = (data: string): SetData => {
  return {
    type: "SET_DATA",
    payload: data
  };
};

export const getData = (): GetData => {
  return {
    type: "GET_DATA"
  };
};

const appReducer = (state: DataStore = dataStore, action: pagesFunction): DataStore => {
  switch (action.type) {
    case "SET_DATA":
      return {
        ...state,
        logInName: action.payload
      };
    case "GET_DATA":
      return state;
    default:
      return state;
  }
};

const store = createStore(appReducer);

export default store;