




// ● 가위 바위 보 클릭 이벤트
for (let i = 0; i < 3; i++) {
    document.querySelectorAll('img')[i].addEventListener('click', (event) => {
        console.log(event.target);
    })
}