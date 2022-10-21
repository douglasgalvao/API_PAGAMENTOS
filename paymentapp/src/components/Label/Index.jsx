import './style.css'
export const Label = (props) => {
  return (
    <label htmlFor={props.htmlFor}>
      <h3 className="label">{props.text}</h3>
    </label>
  );
};
