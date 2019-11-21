import React, { Component } from 'react';

export default class Search extends Component {

	constructor(props){
		super(props);
		this.count = 0;
		this.onChangeText = this.onChangeText.bind(this);
		this.state = {
			text:"",
			searchCount:this.count,
			wordCount:0
		}
	}
	doSearch(){
		this.count++;
		this.setState({
			searchCount:this.count
		});
	}
	onChangeText(e){
		var count = e.target.value.length ;
		this.setState({
			text:e.target.value,
			wordCount:count
		})
	}
	render(){
		return (
			<div>
				<input type="text" value={this.state.text} onChange={this.onChangeText} />
				<button onClick={this.doSearch.bind(this)}>Search</button>
				<div>Search Text: {this.state.text}</div>
        		<div>Search Count: {this.state.searchCount}</div>
        		<div>Result Count: {this.state.wordCount}</div>
			</div>
		);
	}
}