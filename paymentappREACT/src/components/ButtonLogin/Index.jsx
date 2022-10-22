import "./style.css";
export const ButtonLogin = (props) => {
  return (
    <button className="btnL" {...props}>
      <h4>{props.text}</h4>
    </button>
  );
};
