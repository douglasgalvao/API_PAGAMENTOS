import './style.css'
export const Input = (props) =>{
    return <input className="input" type={props.type} id={props.id} style={props.style}/>
}