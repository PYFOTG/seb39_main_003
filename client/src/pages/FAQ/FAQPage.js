import styled from "styled-components";
import React from "react";
import Reply from "../Community/detail/Reply";
import { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import { useLocation } from "react-router";

const Wrapper = styled.div`
  //게시글 확인 화면
  .replytettitory {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;

    background-color: #f9f9f9;
  }
  .rbackground {
    display: flex;
  }
  /* //게시글 제목
  .cposttop {
    width: 95vw;
    margin-top: 30px;
    padding: 10px 10px;

    display: flex;
    flex-direction: row;
    justify-content: space-around;
    align-items: center;

    background-color: rgb(146 99 255);
  }
  .cposttext {
    display: flex;
    flex-direction: row;
    justify-content: center;
    align-items: center;

    color: #f9f9f9;
    font-weight: bold;
  }
  //게시글 내용
  .cpcontent {
    padding: 30px;

    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: flex-start;
  }
  .cpostcontent {
    text-align: start;
    font-weight: 500;
  } */
  //
  .questions {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
  }
  .qtbox{
    display: flex;
    flex-direction: row;
    justify-content: center;
    align-items: center;
  }
`;

function FAQPage() {
  const navigate = useNavigate();
  const location = useLocation();

  console.log(location);

  const [faqList, setFaqList] = useState([]);

  useEffect(() => {
    fetch(`http://211.58.40.128:8080/api/v1/board/${location.state.id}`, {
      method: "GET",
      headers: {
        "content-Type": "application/json",
      },
      //get요청이라 body는 필요없어
    })
      .then((res) => res.json())
      .then((res) => {
        setFaqList(res.data);
        console.log(res.data);
      })
      .catch((err) => console.log(err));
  }, []);

  return (
    <Wrapper>
      {/* 게시글 확인 화면 */}
      <div className="replytettitory">
        <div className="rbackground">
          {/* 게시글 제목 */}
          {/* <div className="cposttop">
                    <span className="cposttext">글 제목</span>
                    <span className="cposttext">내용</span>
                    <span className="cposttext">작성자</span>
                </div> */}

          {/* 게시글 내용 */}
          {/* <div className='cpcontent'>
                  <span className='cpostcontent'>FAQPage 개별 포스트 확인</span>
                </div> */}

          {/* {faqList &&faqList.map((el, index) => { */}

          {/* return ( */}
          <div
            className="questions"
            //   key={index} // 고유번호
          >
            <div className="qtbox">
              <span className="article">{faqList.nickName}</span>
              <span className="article">{faqList.title}</span>
            </div>
            <span className="article">{faqList.boardContents}</span>
          </div>
          {/* ); */}
          {/* })} */}

          {/* 댓글 작성란 및 작성된 댓글 목록 */}
          <Reply />
        </div>
      </div>
    </Wrapper>
  );
}

export default FAQPage;
