import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import { Login } from "../pages/Login/Index";
import { Register } from "../pages/Register/Index";
export const AppRouter = () => {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Login/>} />
        <Route path="/register" element={<Register/>} />
      </Routes>
    </Router>
  );
};
