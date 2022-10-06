import React from 'react'
import styled from 'styled-components'

const Wrapper = styled.div`
box-sizing: border-box;
.background{
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
  align-items: center;
}
//간편 로그인 텍스트
.socialLoginText{}
.socialLoginBox{}
.loginbox1{}
.icon{}
.textbox{}
.text{}
`

function SocialLogin() {
  return (
    <Wrapper>
        <div>
            <div className='background'>
                <div className='socialLoginText'>간편 로그인</div>
                {/* 간편로그인 영역1 */}
                <div className='socialLoginBox'>
                    <div className='loginbox1'>
                        <div className='icon'>네이버 아이콘</div>
                        <div className='textbox'>
                          <div className='text'>네이버 로그인</div>
                        </div>
                    </div>
                    <div className='loginbox2'>
                    <div className='icon'>카카오 아이콘</div>
                        <div className='textbox'>
                          <div className='text'>카카오 로그인</div>
                        </div>
                    </div>
                    <div className='loginbox3'>
                    <div className='icon'>구글 아이콘</div>
                        <div className='textbox'>
                          <div className='text'>구글 로그인</div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </Wrapper>
  )
}

export default SocialLogin