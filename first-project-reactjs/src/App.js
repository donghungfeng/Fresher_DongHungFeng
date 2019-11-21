import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import './App.css';

import { BrowserRouter as Router, Switch, Route, Link } from 'react-router-dom';

import Create from './components/create.component';
import Edit from './components/edit.component';
import Index from './components/index.component';

import Search from './search_component/search.component'

function App() {
    return (
    <div className="container">
      <nav className="navbar navbar-expand-lg navbar-light bg-light">
        <Link to={'/'} className="navbar-brand">React CRUD</Link>
        <div className="collapse navbar-collapse" id="navbarSupportedContent">
          <ul className="navbar-nav mr-auto">
          <li className="nav-item">
              <Link to={'/'} className="nav-link">Home</Link>
            </li>
            <li className="nav-item">
              <Link to={'/create'} className="nav-link">Create</Link>    
            </li>
            <li className="nav-item">
              <Link to={'/index'} className="nav-link">Index</Link>
            </li>
            <li className="nav-item">
              <Link to={'/search'} className="nav-link">Search</Link>
            </li>
          </ul>
        </div>
      </nav> <br/>
      <h2>Dong Hung's React Page</h2> <br/>
      <Switch>
          <Route exact path='/create' component={ Create } />
          <Route path="/edit/:id" component={ Edit }/> 
          <Route path='/index' component={ Index } />
          <Route path='/search' component = { Search } />
      </Switch>
    </div>
    );
}

export default App;