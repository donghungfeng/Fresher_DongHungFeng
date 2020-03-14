import React, {Component} from 'react';
import axios from 'axios';
import TableRow from './TableRow';
import SelGroupTopic from './SelGroupTopic';
const url = "http://localhost:8084";

export default class Index extends Component {
    constructor(props) {
        super(props);
        this.state = {topics: [],grouptopics: []};
    }
    componentDidMount() {
        axios.get(url+'/topics')
            .then(response => {
                console.log(response.data);
                this.setState({topics: response.data});
            })
            .catch(function (error) {
                console.log(error);
            });
        axios.get(url+'/grouptopics')
            .then(response => {
                console.log(response.data);
                this.setState({grouptopics: response.data});
            })
            .catch(function (error) {
                console.log(error);
            });
    }

    tabRow() {
        return this.state.topics.map(function (object, i) {
            return <TableRow obj={object} key={i}/>;
        });
    }
    selOption(){
        return this.state.grouptopics.map(function (object, i) {
            return <SelGroupTopic obj={object} key={i}/>;
        });
    }
    handleOnSelChange(e){
        axios.get(url+'/topic/getbygroupid/'+e.target.value)
            .then(response => {
                console.log(response.data);
                this.setState({topics: response.data});
            })
            .catch(function (error) {
                console.log(error);
            });
    }
    handleOnSelDBChange(e){
        axios.get(url+'/datasource/'+e.target.value)
            .then(response => {
                console.log(response.data);
            })
            .catch(function (error) {
                console.log(error);
            });

        axios.get(url+'/topics')
            .then(response => {
                console.log(response.data);
                this.setState({topics: response.data});
            })
            .catch(function (error) {
                console.log(error);
            });
    }

    handleOnTypeSearch(e){
        if(e.target.value === ""){

            axios.get(url+'/topics')
            .then(response => {
                console.log(response.data);
                this.setState({topics: response.data});
            })
            .catch(function (error) {
                console.log(error);
            });
            return
        }
         axios.get(url+'/topics/searchbyname/'+e.target.value)
            .then(response => {
                console.log(response.data);
                this.setState({topics: response.data});
            })
            .catch(function (error) {
                console.log(error);
            });
    }

    render() {
        return (
            <div className="row">
                 <div className="col-md-1">
                    <h6>Chọn DB</h6>
                </div>
                <div className="col-md-3">
                    <select className="form-control" onChange={this.handleOnSelDBChange.bind(this)}>
                        <option value="oracle">Oracle</option>
                        <option value="sqlite">Sqlite</option>
                    </select>
                </div>
                 <div className="col-md-8">
                    
                </div>
                <br />
                <br />
                <div className="col-md-1">
                    <h6>Chọn nhóm</h6>
                </div>
                <div className="col-md-3">
                    <select className="form-control" onChange={this.handleOnSelChange.bind(this)}>
                    <option value="0" selected>Get all</option>
                    {this.selOption()}
                    </select>
                </div>
                <div className="col-md-1">
                    <h6>Tìm kiếm</h6>
                </div>
                <div className="col-md-7">
                    <input type="text" className="form-control" onChange={this.handleOnTypeSearch.bind(this)}/>
                </div>
                <h3 align="center">Topics List</h3>
                <table className="table table-striped" style={{marginTop: 20}}>
                    <thead>
                    <tr>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Description</th>
                        <th colSpan="2">Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    {this.tabRow()}
                    </tbody>
                </table>
            </div>
        );
    }
}