import React from "react";
import styled from "styled-components";
import { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import { useLocation } from "react-router-dom";

const Wrapper = styled.div``;

function FAQDelete() {
  const [faqlist, setFaqList] = useState([]);
  const location = useLocation();
  const navigate = useNavigate();

//   const titleInput = (e) => {
//     setTitle(e.target.value);
//   };
//   const contentInput = (e) => {
//     setContent(e.target.value);
//   };

  const deleteContent = () => {
    fetch(`http://211.58.40.128:8080/api/v1/board/${location.state.id}`, {
      method: "DELETE",
      headers: {
        // 'Authorization' : Token,
        "content-Type": "application/json",
      },
      body: JSON.stringify({
        memberId: "000001",
        categoryId: 31,
      }),
    })
      .then(() => {
        navigate(`/FAQ`);
      })
      .catch(() => {
        console.log("실패");
      });
  };

  return (
    <Wrapper>
      <div>
        <button className="deleteButton" onClick={deleteContent}>게시글 삭제</button>
      </div>
    </Wrapper>
  );
}

export default FAQDelete;
