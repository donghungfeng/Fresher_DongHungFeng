import React, { Component } from 'react';
import axios from 'axios';
import SelGroupTopic from './SelGroupTopic'

export default class Edit extends Component {
	constructor(props) {
		super(props);
		this.onChangeName  = this.onChangeName.bind(this);
		this.onChangeDescription = this.onChangeDescription.bind(this);
		this.onSubmit = this.onSubmit.bind(this);
		this.onChangeGroup = this.onChangeGroup.bind(this);

		this.state = {
			id: '',
			name: '',
			description:'',
			groupid:0,
			grouptopics: []
		}
	}

	componentDidMount() {
		axios.get('http://localhost:8082/topics/'+this.props.match.params.id)
		.then(response => {
			this.setState({
				id: response.data.id,
				name: response.data.name,
				description: response.data.description,
				groupid:response.data.groupid });
		})
		.catch(function (error) {
			console.log(error);
		});
		axios.get('http://localhost:8082/grouptopics/')
		.then(response => {
			this.setState({
				grouptopics:response.data});
		})
		.catch(function (error) {
			console.log(error);
		});
	}

	onChangeName(e) {
		this.setState({
			name: e.target.value
		})
	}
	onChangeDescription(e) {
		this.setState({
			description: e.target.value
		})
	}
	onChangeGroup(e){
		this.setState({
			groupid:e.target.value
		})
	}

	onSubmit(e) {
		e.preventDefault();
		axios.get(url).then(response => console.log(response.data));
		var url = '';
		var body = {
			id:this.state.id,
			name:this.state.name,
			description:this.state.description,
			groupid:this.state.groupid
		}
		axios({
			method: 'post',
			url: 'http://localhost:8082/topic/update',
			data: body
		})
		this.props.history.push('/index');
	}

	selOption(){
        return this.state.grouptopics.map(function (object, i) {
            return <SelGroupTopic obj={object} key={i}/>;
        });
    }

	render() {
		return (
			<div style={{ marginTop: 10 }}>
			<h3 align="center">Update Topic Info</h3>
			<form onSubmit={this.onSubmit}>
			<div className="form-group">
			<label>Topic id:  </label>
			<input
			type="text"
			className="form-control"
			value={this.state.id} disabled
			/>
			</div>
			<div className="form-group">
			<label>Topic Name: </label>
			<input type="text"
			className="form-control"
			value={this.state.name}
			onChange={this.onChangeName}
			/>
			</div>
			<div className="form-group">
			<label>Description: </label>
			<input type="text"
			className="form-control"
			value={this.state.description}
			onChange={this.onChangeDescription}
			/>
			</div>
			<div className="form-group">
                <label>Group: </label>
                <select className="form-control" value={this.state.groupid} onChange={this.onChangeGroup}>
                {this.selOption()}
                </select>
            </div>
			<div className="form-group">
			<input type="submit"
			value="Update Topic Info"
			className="btn btn-primary"/>
			</div>
			</form>
			</div>
			)
		}
	}