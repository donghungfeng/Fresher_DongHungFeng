import React, {Component} from 'react';
import axios from 'axios';
import SelGroupTopic from './SelGroupTopic'

export default class Create extends Component {
    constructor(props) {
        super(props);
        this.onChangeId = this.onChangeId.bind(this);
        this.onChangeName = this.onChangeName.bind(this);
        this.onChangeDescription = this.onChangeDescription.bind(this);
        this.onSubmit = this.onSubmit.bind(this);
        this.handleOnSelChange = this.handleOnSelChange.bind(this);

        this.state = {
            id: '',
            name: '',
            description:'',
            groupid:0,
            grouptopics: []
        }
    }

    componentDidMount() {
        axios.get('http://localhost:8082/grouptopics')
            .then(response => {
                console.log(response.data);
                this.setState({grouptopics: response.data});
            })
            .catch(function (error) {
                console.log(error);
            });
    }


    onChangeId(e) {
        this.setState({
            id: e.target.value
        });
    }

    onChangeName(e) {
        this.setState({
            name: e.target.value
        });
    }

    onChangeDescription(e) {
        this.setState({
            description: e.target.value
        });
    }

    selOption(){
        return this.state.grouptopics.map(function (object, i) {
            return <SelGroupTopic obj={object} key={i}/>;
        });
    }

    handleOnSelChange(e){
       this.setState({
            groupid:e.target.value
       });
    }

    onSubmit(e) {
        e.preventDefault();

        if(this.state.groupid == 0){
            alert("Chọn 1 nhóm");
            return ;
        }
        const obj = {
            id: this.state.id,
            name: this.state.name,
            description: this.state.description,
            groupid: this.state.groupid
        };
        axios.post('http://localhost:8082/topic/add', obj)
            .then(res => console.log(res.data));
        this.setState({
            id: '',
            name: '',
            description: '',
            groupid: 0
        });

        this.props.history.push('/index');
    }

    render() {
        return (
            <div style={{marginTop: 10}}>
                <h3>Add New Topic</h3>
                <form onSubmit={this.onSubmit}>
                    <div className="form-group">
                        <label>Topic id: </label>
                        <input type="text" className="form-control" onChange={this.onChangeId} value={this.state.id} />
                    </div>
                    <div className="form-group">
                        <label>Topic Name: </label>
                        <input type="text" className="form-control" value={this.state.name}
                               onChange={this.onChangeName}/>
                    </div>
                    <div className="form-group">
                        <label>Description: </label>
                        <input type="text" className="form-control" value={this.state.description}
                               onChange={this.onChangeDescription}/>
                    </div>
                    <div className="form-group">
                        <label>Group: </label>
                        <select className="form-control" onChange={this.handleOnSelChange}>
                        <option value="0">--Chọn nhóm--</option>
                        {this.selOption()}
                        </select>
                    </div>
                    <div className="form-group">
                        <input type="submit" value="Add Topic" className="btn btn-primary"/>
                    </div>
                </form>
            </div>
        )
    }
}