export {menuTemplate};

function menuTemplate(){

let menuTemplate = document.createElement('div');
menuTemplate.id = 'header';
menuTemplate.classList.add('container');
menuTemplate.innerHTML =
`<nav class="navbar navbar-expand-lg">
<div class="container">
    <a class="navbar-brand text-white" href="#"><i class="fa fa-graduation-cap fa-lg mr-2"></i>CINEMA</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#nvbCollapse" aria-controls="nvbCollapse">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="nvbCollapse">
        <ul class="navbar-nav ml-auto">
            <li class="nav-item pl-1">
                <a class="nav-link" href="#">
                    <i class="fa fa-home fa-fw mr-1">
                    </i>Peliculas</a>
            </li>
            <li class="nav-item active pl-1">
                <a class="nav-link" href="#"><i class="fa fa-th-list fa-fw mr-1"></i>Catalogo</a>
            </li>
            <li class="nav-item pl-1">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button" aria-expanded="false">Genero</a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="#scrollspyHeading3">Acción</a></li>
                        <li><a class="dropdown-item" href="#scrollspyHeading4">Aventura</a></li>
                        <li><a class="dropdown-item" href="#scrollspyHeading5">Terror</a></li>
                        <li><a class="dropdown-item" href="#scrollspyHeading6">Ciencia Ficción</a></li>
                        <li><a class="dropdown-item" href="#scrollspyHeading7">Romantica</a></li>
                        <li><a class="dropdown-item" href="#scrollspyHeading8">Comedia</a></li>
                    </ul>
                </li>
            </li>
            <li class="nav-item pl-1">
                <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" data-bs-toggle="dropdown" href="#" role="button" aria-expanded="false">Plataforma</a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="#scrollspyHeading3">NETFLIX</a></li>
                        <li><a class="dropdown-item" href="#scrollspyHeading4">HBO</a></li>
                        <li><a class="dropdown-item" href="#scrollspyHeading5">AMAZON</a></li>
                        <li><a class="dropdown-item" href="#scrollspyHeading6">DAZAN</a></li>
                        <li><a class="dropdown-item" href="#scrollspyHeading7">RAKUTEN TV</a></li>
                        <li><a class="dropdown-item" href="#scrollspyHeading8">PARAMOUNT CHANNEL</a></li>
                    </ul>
                </li>
            </li>
            <form class="form-inline my-2 my-lg-0">
                <input class="form-control mr-sm-2" type="search" placeholder="Buscar" aria-label="Search">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-house-door" viewBox="0 0 16 16">
                    <path d="M8.354 1.146a.5.5 0 0 0-.708 0l-6 6A.5.5 0 0 0 1.5 7.5v7a.5.5 0 0 0 .5.5h4.5a.5.5 0 0 0 .5-.5v-4h2v4a.5.5 0 0 0 .5.5H14a.5.5 0 0 0 .5-.5v-7a.5.5 0 0 0-.146-.354L13 5.793V2.5a.5.5 0 0 0-.5-.5h-1a.5.5 0 0 0-.5.5v1.293L8.354 1.146zM2.5 14V7.707l5.5-5.5 5.5 5.5V14H10v-4a.5.5 0 0 0-.5-.5h-3a.5.5 0 0 0-.5.5v4H2.5z"/>
                </svg>
            </form>
        </ul>
    </div>
</div>
</nav>`
    return menuTemplate;
}
