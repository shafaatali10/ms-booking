import './App.css';
import { BrowserRouter as Router } from 'react-router-dom';
import Header from './common/Header.js'

function App() {

  return (
    <Router basename={''}>
      <Header />
    </Router>
  );
}

export default App;
