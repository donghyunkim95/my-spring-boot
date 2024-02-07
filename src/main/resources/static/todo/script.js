const API_URL = "/api/todos";
let main = document.querySelector("#todos");


async function getList() {

    let res = await fetch(API_URL);
    let data = await res.json();
    //초기화
    main.innerHTML = "";
    for (let result of data) {

        let HTML =
            `
            <li class="${result.done === true ? "completed" : ""}">${result.content}
            <input type="hidden" value="${result.id}" /></li>
            `;

        main.innerHTML += HTML;
    }
}

getList();


document.forms[0].addEventListener("submit", (e) => {
    e.preventDefault();
    // console.log(e);
    let keyword = document.getElementById('input')
    let value = keyword.value;
    // console.log(value);
    addTodo(value);
})


//todo-list 저장하기
function addTodo(value) {

    //1.todo를 엔터쳤을때 post fetch -> fetch post방법 서치
    //2.넘겨줄때 json으로 넘겨주려면, 1번에서 post할 때 json타입으로 넘겨주어야 함
    //@POSTMapping
    //잘 들어왔을 때 맵에 등록
    //3. 추가한 데이터 삽입 후 업데이트
    //버블링을 이용해서 이벤트가 발생하는 최상위 부모에 걸어주기 (ul)



    let res = fetch("api/todos/addTodo", {

        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify({
            //id는 서버에 위임하는 게 좋음
            content: value, //todo에 닮긴 값을 넣어주어야함
            done: "false"
        }),
    }).then(res => getList());
    //검색창에 검색한 기록이 떠있지 않게
    //fetch가 완전히 끝난 후에 value를 ""지워줘야 함
    document.getElementById('input').value = "";

    // let data = await res.json();
    // console.log(data);
    // await getList();
}


//마우스 우클릭 시 메뉴 해제
window.oncontextmenu = function () {
    return false;
}

let ul = document.querySelector("#todos");
ul.addEventListener("mousedown", (event) => {

    if (event.button === 2 || event.which === 3) { //우 클릭 했을 때 사이트마다 button인지, which인지 다르기때문에 둘 다 조건으로 넣어주기
        //우클릭 -> 삭제
        // console.log(event.target);
        event.target.remove();
        let delElem = event.target.childNodes[1].value;
        deleteTodo(delElem);
        // console.log(event.target)

    } else {
        //좌클릭 -> 취소선
        if (event.target.className == "") {
            event.target.className += "completed";
            let chkValue = event.target.childNodes[1].value;
            updateTodo_T(chkValue);

        } else {
            event.target.className = "";
            let chkValue = event.target.childNodes[1].value;
            updateTodo_F(chkValue);
        }
    }
})

async function updateTodo_F (chkValue){
    let res = await fetch("api/todos/updateTodo", {
        method : "PUT",
        headers : {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            id: chkValue,
            done: "false"
        }),
    })
}

async function updateTodo_T (chkValue){
    let res = await fetch("api/todos/updateTodo", {
        method : "PUT",
        headers : {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            id: chkValue,
            done: "true"
        }),
    })
}



async function deleteTodo (delElem){
    let res = await fetch("api/todos/deleteTodo", {
        method : "DELETE",
        headers : {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            id: delElem
        }),
    })
}