import React, { Component } from 'react';
import axios from 'axios';
const url = "http://localhost:8082/topics";
var data = [];

class Example3 extends Component {
	state = {
    loading: true,
    person: null
  };

  render() {
    if (this.state.loading) {
      axios.get(url).then(response => console.log(response.data));
      alert("ok");
      var body = {
        id:'07',
        name:'ok fix',
        description:'demo fix'
      }
      axios({
        method: 'post',
        url: 'http://localhost:8082/topic/update',
        data: body
      })
      return <div>loading...</div>;
    }

    if (!this.state.person) {
      return <div>didn't get a person</div>;
    }
    return (
      <div>
        
      </div>
    );
  }
} 
export default Example3