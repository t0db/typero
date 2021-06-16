import React from "react";
import { useSelector } from "react-redux";

const EndGamePage = () => {
  const notification = useSelector(state => state.notification);
  return (
    <div>{notification}</div>
  );
};

export default EndGamePage;