import React, { Component } from 'react';
import { Link } from 'react-router-dom';
import axios from 'axios';


class SelGroupTopic extends Component {

    constructor(props) {
        super(props);
    }

  render() {
    return (
        <option value={this.props.obj.grouptopicid}>{this.props.obj.name}</option>
    );
  }
}

export default SelGroupTopic;